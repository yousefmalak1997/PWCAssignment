package com.pwc.complaintmanagementportal.complaint;

import com.pwc.complaintmanagementportal.CurrentUserCredintial;
import com.pwc.complaintmanagementportal.uses.Users;
import com.pwc.complaintmanagementportal.uses.UsersRepository;
import com.pwc.complaintmanagementportal.uses.UsersRole;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ComplaintsService {

    private final ComplaintRepository complaintRepository;
    private final UsersRepository usersRepository;
    private final CurrentUserCredintial currentUserCredintial;

    public List<Complaints> getComplaints() {

        List<String> currentUserRole = currentUserCredintial
                .getCurrentUserCredUserRole()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());



        if ( currentUserRole.contains(UsersRole.USER.getEnumName())) {
            //here if the user role is User we only return rhe complaints that are
            //created by the user himself only.
            Long id = currentUserCredintial.getCurrentUserCredUserId();
            Optional<List<Complaints>> byCreatorId = complaintRepository.findByCreatorId(id);
            return byCreatorId.orElseGet(ArrayList::new);

        } else if (currentUserRole.contains(UsersRole.ADMIN.getEnumName())) {
            //here if the user is admin user then we return all th complaints
            //in the system
            List<Complaints> complaintsDetails = complaintRepository.findAll();
            return complaintRepository.findAll();
        }

        return new ArrayList<>();

    }

    public String addingComplaints(Complaints complaints) {
        //getting user id from authentication to use it in the insert as creatorId
        Long id = currentUserCredintial.getCurrentUserCredUserId();

        if( id != null ){
            // set some values the must be inserted by the system.
            complaints.setCreatorId(id);
            complaints.setDateCreated(LocalDateTime.now());
            complaints.setComplaintsStatus(ComplaintsStats.PENDING);
            //save all the values from the User how created the complaint.
            complaintRepository.save(complaints);
            return "success";
        } else {
            return "Fail";
        }
    }

    public String updateComplaints(Long comId , String complaintsStats ) {

        if ( complaintsStats.equals(ComplaintsStats.DISMISSED.getEnumName()) ) {
            complaintRepository.updateById(comId,LocalDateTime.now(),ComplaintsStats.DISMISSED);
            return "success";
        } else if ( complaintsStats.equals(ComplaintsStats.RESOLVED.getEnumName()) ) {
            complaintRepository.updateById(comId,LocalDateTime.now(),ComplaintsStats.RESOLVED);
            return "success";
        }

        return "Fail";
    }
}
