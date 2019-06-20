package tn.isetso.service;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
@Data
@ToString
public class ModuleData {
    private Long moduleId;
    private Long entrepriseId;
   private String action;
}
