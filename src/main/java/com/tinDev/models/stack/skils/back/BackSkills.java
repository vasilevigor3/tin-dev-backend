package com.tinDev.models.stack.skils.back;

import com.tinDev.models.stack.skils.AbstractSkill;
import lombok.Data;

import java.util.List;

@Data
public class BackSkills extends AbstractSkill {
   //todo FrameWorkSkills,DataBaseSkills... should be as data in DB not as Enum
   private List<FrameWorkSkills> frameWorkSkills;
   private List<DataBaseSkills> dataBaseSkills;
   //
   //private List<ProgramingLanguages> programingLanguages;

}
