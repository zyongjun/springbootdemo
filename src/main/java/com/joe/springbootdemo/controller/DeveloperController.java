package com.joe.springbootdemo.controller;

import com.github.pagehelper.PageHelper;
import com.joe.springbootdemo.mapper.DeveloperMapper;
import com.joe.springbootdemo.model.CommonResult;
import com.joe.springbootdemo.pojo.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class DeveloperController{

    @Autowired
    DeveloperMapper developerMapper;

    @RequestMapping(value = "/listAll",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult listDevelopers(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Developer> developers = developerMapper.getAllDevelopers();
        CommonResult result = new CommonResult();
        if (developers.size() > 0) {
            result.setSuccess();
            result.setData(developers);
        }else{
            result.setFail();
        }
        return result;
    }

    @RequestMapping("/getDeveloper")
    @ResponseBody
    public CommonResult getDeveloper(String id) {
        CommonResult result = new CommonResult();
        Developer developer = developerMapper.getDevelopers(id);
        if(developer != null){
            result.setSuccess();
            result.setData(developer);
        }else{
            result.setFail();
        }

        return result;
    }

    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addDeveloper(Developer developer) {
        CommonResult result = new CommonResult();
        if(developerMapper.addDeveloper(developer)){
            result.setSuccess();
            result.setData(true);
        }else{
            result.setFail();
            result.setData(false);
        }
        return result;
    }

    @RequestMapping(value = "/updateDeveloper", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDeveloper(Developer developer) {
        CommonResult result = new CommonResult();
        if (developerMapper.updateDeveloper(developer)) {
            result.setSuccess();
            result.setData(true);
        }else{
            result.setFail();
            result.setData(false);
        }
        return result;
    }

    @RequestMapping(value = "/deleteDeveloper", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult deleteDeveloper(String id) {
        CommonResult result = new CommonResult();
        if (developerMapper.deleteDeveloper(id)) {
            result.setSuccess();
            result.setData(true);
        }else{
            result.setFail();
            result.setData(false);
        }
        return result;
    }
}
