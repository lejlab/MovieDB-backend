package com.moviedb.Celebs.controllers.celebJobs;

import com.moviedb.Celebs.controllers.celebJobs.exceptions.CelebJobsNotFoundException;
import com.moviedb.Celebs.controllers.jobs.exceptions.JobsNotFoundException;
import com.moviedb.Celebs.models.Celeb;
import com.moviedb.Celebs.models.CelebJobs;
import com.moviedb.Celebs.models.Job;
import com.moviedb.Celebs.services.CelebJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.moviedb.Celebs.repositories.CelebJobsRepository;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@RestController
public class CelebJobController {
    @Autowired
    private CelebJobsService celebJobsService;
    @Autowired
    CelebJobsRepository celebJobsRepository;

    @GetMapping("/celebjobs")
    public List<CelebJobs> getAll(){
        return celebJobsService.getAll();
    }

    @GetMapping("/celebjobs/{id}")
    public CelebJobs getOneById(@PathVariable(value = "id") Integer id) {
        return celebJobsService.getOneById(id).orElseThrow(() -> new CelebJobsNotFoundException(id));
    }

    @GetMapping("/celebjobs/list/{id}")
    public List<CelebJobs> findAllById(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer celebJobId = parseInt(id);

        if (type.equals("celeb")){
            return celebJobsService.getAllByCelebId(celebJobId);
        }
        else if (type.equals("job")) {
            return celebJobsService.getAllByJobId(celebJobId);
        }
        else {
            return new ArrayList<CelebJobs>();
        }
    }

    @PostMapping("/celebjobs")
    public CelebJobs addOne(@RequestBody CelebJobs newCelebJob) {
        return celebJobsService.addOne(newCelebJob);
    }

    @PutMapping("/celebjobs/{id}")
    public CelebJobs editOne(@RequestBody CelebJobs newData, @PathVariable("id") Integer id) {
        return celebJobsService.editOne(newData, id);
    }

    @DeleteMapping("/celebjobs/{id}")
    public void removeOne(@PathVariable Integer id) {
        celebJobsService.removeOne(id);
    }
}
