package com.pwc.complaintmanagementportal.complaint;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "complaints")
@AllArgsConstructor
public class ComplaintsController {

    private final ComplaintsService complaintsService;

    @GetMapping("/view")
    public List<Complaints> GetAllComplaints() {
        return complaintsService.getComplaints();
    }

    @PostMapping("/add")
    public String AddComplaints(@RequestBody Complaints complaints) {
        return complaintsService.addingComplaints(complaints);
    }

    @PostMapping("/update")
    public String updateComplaints(@RequestBody Long id, String complaintsStats) {
        return complaintsService.updateComplaints(id,complaintsStats);
    }
}
