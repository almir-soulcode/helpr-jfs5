package org.soulcodeacademy.helpr.config;

import org.soulcodeacademy.helpr.services.PopulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

// indica que esta classe será gerenciada pelo Spring
// e que ela é uma classe de configuração
@Configuration
@Profile("dev") // será instanciada apenas se o perfil ativo for "dev"
public class DevConfig {
    // Esta classe irá chamar o PopulateService caso o perfil ativo seja de desenvolvimento
    @Autowired // injeta o service na classe config
    private PopulateService populateService;

    // é ler as .properties
    @Value("${spring.jpa.hibernate.ddl-auto}") // vai acessar a propriedade
    private String ddlAuto;

    // Após construir o DevConfig, executa o método abaixo
    @PostConstruct // faz com que o método execute após a instância ser criada
    public void init() {
        // se o modo for create, insere os dados fictícios
        if(this.ddlAuto.equals("create")) {
            // inserir os dados novos caso a tabela tenha sido dropada
            this.populateService.populate();
        }
    }
}
