package com.jxmall.activity.general.report.adapter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import com.jxmall.activity.general.report.application.ActivityGeneralReportApplication;
import com.jxmall.activity.general.report.domain.aggregate.activity.root.ActivityGeneralReport;

@RestController
@RequestMapping("/jxmall/activity_general_reports")
public class ActivityGeneralReportController {

    @Autowired
    private ActivityGeneralReportApplication activityGeneralReportApplication;

    @GetMapping
    public ResponseEntity<List<ActivityGeneralReport>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityGeneralReportApplication.search(key));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ActivityGeneralReport activitieGeneralReport, UriComponentsBuilder builder) {
        activityGeneralReportApplication.create(activitieGeneralReport);
        return ResponseEntity.created(builder.path("/activity_general_reports/{id}").buildAndExpand(activitieGeneralReport.getId()).toUri())
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityGeneralReport> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityGeneralReportApplication.findById(id));
    }
}