package com.tinDev.models.stack.skils.front;

import com.tinDev.models.stack.skils.AbstractSkill;
import com.tinDev.models.stack.skils.back.DataBaseSkills;
import com.tinDev.models.stack.skils.back.FrameWorkSkills;
import lombok.Data;

import java.util.List;

@Data
public class FrontSkills extends AbstractSkill {
    //todo import packages check!
    //this skills from "back" package
    private List<FrameWorkSkills> frameWorkSkills;
    private List<DataBaseSkills> dataBaseSkills;
}
