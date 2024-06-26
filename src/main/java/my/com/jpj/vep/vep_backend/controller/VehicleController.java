package my.com.jpj.vep.vep_backend.controller;

import lombok.val;
import my.com.jpj.vep.vep_backend.service.VepVehicleService;
import my.com.jpj.vep.vep_model.entity.VehicleVep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    @Autowired
    private VepVehicleService vepVehicleService;

    @RequestMapping( method = RequestMethod.GET,
            value = "/vehicle",
            produces = { "application/json" })
    public ResponseEntity<VehicleVep> getVehicle(@RequestParam(value = "vecRegNo", required = true) String vecRegNo) {
        val vehicle = vepVehicleService.findByVecRegNo(vecRegNo);
        return ResponseEntity.ok(vehicle);
    }

}
