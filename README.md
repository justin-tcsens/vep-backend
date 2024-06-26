## Workspace Preparation
- Obtain the source code with git command, or download it via HTTP link.
- From Intellij IDE (vep-model project), open the project from File -> New -> Module from Existing Sources.
- ![image](https://github.com/justin-tcsens/vep-backend/assets/102033651/10206906-6db6-42e7-adf2-d6c9e022d52a)
- Navigate to the code workspace, choose pom.xml from the package.
- Shall IDE prompt an alert, choose 'Open As Project'

## Objective
- To create API services which connect to database, with shared-library created previously.
- Folloing are ERD diagram for the activity:
- ![image](https://github.com/justin-tcsens/vep-model/assets/102033651/7670e8f8-d601-4018-b3b4-d377c7ecfc2f)

## Task
**Build backend service to interact with database, with vep-model.jar created previously**
- Create two (2) new packages, under /src/main/java/my/com/jpj/vep/vep_model
  - controller
  - service
- The project structure should be similar as below
- ![image](https://github.com/justin-tcsens/vep-backend/assets/102033651/a180ba04-1719-43ad-8aa1-e841a2f07550)
- Open pom.xml in vep-backend project.
- add vep-model.jar created previously into the project dependency.
- ![image](https://github.com/justin-tcsens/vep-backend/assets/102033651/fbe34e6d-1487-4d9f-8088-750dd27bd55e)
- Create new java class under ``service`` package, namely ``VepVehicleService.java``.
- Following please find the snapshot of code as below:-
  ```
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
  ```
- Create new java class under ``controller`` package, namely ``VehicleController.java``.
- Following please find the snapshot of code as below:-
```
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
```
- add database connection source to ``application.properties`` under ``resource`` folder.
```
  # JDBC Data Source
  spring.datasource.driverClassName=org.mariadb.jdbc.Driver
  spring.datasource.url=jdbc:mariadb://localhost:3306/jpjvep-dev?allowMultiQueries=true
  spring.datasource.username=app
  spring.datasource.password=password
  spring.datasource.testOnBorrow=true
  spring.datasource.testWhileIdle=true
  spring.datasource.timeBetweenEvictionRunsMillis=60000
  spring.datasource.minEvictableIdleTimeMillis=30000
  spring.datasource.validationQuery=SELECT 1
  spring.datasource.max-active=5
  spring.datasource.max-idle=5
  spring.datasource.max-wait=8000
```
- Lastly, add following code snaplet to ``VepBackendApplication.java``, under ``@SpringBootApplication`` annotation.
  ```
    @ComponentScan(basePackages = {"my.com.jpj.vep.vep_backend","my.com.jpj.vep.vep_model", "com.jpj.vep.vep_model"})
  ```
- We are ready to go ~!

**Run the application**
- At Intellij IDE, create new run configuration file as per screenshot below:-
- ![image](https://github.com/justin-tcsens/vep-backend/assets/102033651/ec98c296-ac68-4c19-a0d4-6b8a876ab3b2)
- On the pop up dialog box, click ``Add New..`` link.
- ![image](https://github.com/justin-tcsens/vep-backend/assets/102033651/d850cdb3-1a58-4faa-9751-e364deee8d72)
- Update the configuration as per screenshot below:
- ![image](https://github.com/justin-tcsens/vep-backend/assets/102033651/f0251216-69ea-46a3-8482-1b4b32cde31a)
- Click OK to save the configuration.
  

