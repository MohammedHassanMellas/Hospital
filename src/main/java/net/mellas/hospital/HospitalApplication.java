package net.mellas.hospital;

import net.mellas.hospital.entities.*;
import net.mellas.hospital.repositories.ConsultationRepository;
import net.mellas.hospital.repositories.MedecinRepository;
import net.mellas.hospital.repositories.PatientRepository;
import net.mellas.hospital.repositories.RendezVousRepository;
import net.mellas.hospital.service.HospitalImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(HospitalImpl hospital,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("Mohammed","Hassan","Kamal").
                    forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospital.savePatient(patient);
                    });
            Stream.of("Marwa","Karima","ikram").
                    forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(Math.random()>0.5?name+"@gmail.com":name+"@hotmail");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospital.saveMedecin(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1= patientRepository.findByNom("Mohammed");

            Medecin medecin  = medecinRepository.findByNom("ikram");

            RendezVous R1= new RendezVous();
            R1.setDateRendezvous(new Date());
            R1.setStatus(StatusRDV.CONFIRMERD);
            R1.setPatient(patient);
            R1.setMedecin(medecin);
            hospital.saveRendezvous(R1);

            RendezVous rendezVous = rendezVousRepository.findAll().get(0);

            Consultation C = new Consultation();
            C.setRapport("Rapport de la consultation ***************");
            C.setDateConsultaion(new Date());
            C.setRendezVous(R1);
            hospital.saveConsultation(C);
        };


    }

}
