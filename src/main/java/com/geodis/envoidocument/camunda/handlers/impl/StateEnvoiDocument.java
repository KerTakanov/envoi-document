package com.geodis.envoidocument.camunda.handlers.impl;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

@Component
public class StateEnvoiDocument extends com.geodis.isscserver.camunda.StateHandler {
    @Override
    protected String topicname() {
        return "envoi-doc";
    }

    @Override
    protected void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) throws UnirestException {
        Boolean est_valide = get("est_valide");
        if (est_valide != null && !est_valide) {
            System.out.println("Le document n'était pas valide");
        }

        System.out.println("Execution activité service");
        System.out.println(String.format("Destinataire: %s", (String)get("destinataire")));
        System.out.println(String.format("Contenu: %s", (String)get("contenu")));
        put("OK", "ok");
    }
}
