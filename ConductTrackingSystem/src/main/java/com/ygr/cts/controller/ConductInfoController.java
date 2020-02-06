package com.ygr.cts.controller;

import com.ygr.cts.service.ConductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yagnaguru.r
 */

@RequestMapping("/conductinfo")
@RestController
public class ConductInfoController {

    @Autowired
    ConductInfoServiceImpl conductInfoService;

    @GetMapping("/details/{id}")
    public Map<String, Object> getConductInfoForId(@PathVariable Long id) {
        return conductInfoService.getConductInfoById(id);
    }

    @DeleteMapping("/details/{id}")
    public void deleteConductInfoForId(@PathVariable Long id) {
        conductInfoService.deleteConductInfoById(id);
    }
}
