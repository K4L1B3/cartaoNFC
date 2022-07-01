package com.nfc_card_project.nfc_card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class NfcCardApplication {

	//LEMBRAR DE ATIVAR O ENABLE MVC QUANDO FOR USAR O SWAGGER 3.0

	public static void main(String[] args) {
		SpringApplication.run(NfcCardApplication.class, args);
	}

}
