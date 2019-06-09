package tn.isetso.service;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
@Data
@ToString
public class AbonnementData {
    private String dateDebut;
    private String dateFin;
    private Integer periode;
    private Double total;
    private String details;
    private String refpayment;
    private Long entrepriseId;
    private Long planId;
    private ArrayList<String> modules;
    private String address;
    private String city;
    private String postal;
    private String paymentMethode;
}
