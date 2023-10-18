package org.sid.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

import java.util.Map;

@SpringBootApplication
public class BillingServiceApplication {

	private VaultTemplate vaultTemplate;

	public BillingServiceApplication(VaultTemplate vaultTemplate) {
		this.vaultTemplate = vaultTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){

		return args -> {
			Versioned.Metadata metadata = vaultTemplate.opsForVersionedKeyValue("secret")
					.put("keypair", Map.of("privateKey","1234","privateKey1","5678","privateKey3","0000"));

		};
	}

}
