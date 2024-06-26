package my.com.jpj.vep.vep_backend.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import my.com.jpj.vep.vep_model.entity.VehicleVep;
import my.com.jpj.vep.vep_model.repository.VepVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VepVehicleService {
    @Autowired
    private VepVehicleRepository vepVehicleRepository;


    public VehicleVep findByVecRegNo(String vecRegNo) {
        val vehicleOwner = vepVehicleRepository.findByVehicleOwner_VecRegNo(vecRegNo);
        log.info("Vehicle Profile: {}", vehicleOwner);
        return vehicleOwner;
    }
}
