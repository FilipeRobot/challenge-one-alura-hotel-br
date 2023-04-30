package com.github.FilipeRobot.service;

import com.github.FilipeRobot.dao.HospedeDAO;
import com.github.FilipeRobot.model.DTO.DadosCompletosHospede;
import com.github.FilipeRobot.model.DTO.DadosHospede;
import com.github.FilipeRobot.model.Hospede;

import javax.persistence.EntityManager;
import java.util.List;

public class HospedeService {
    private final EntityManager entityManager;

    private final HospedeDAO hospedeDAO;

    public HospedeService(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.hospedeDAO = new HospedeDAO(this.entityManager);
    }

    public void registrar(DadosHospede dados) {
        Hospede hospede = new Hospede(dados);

        this.entityManager.getTransaction().begin();

        hospedeDAO.registrar(hospede);

        this.entityManager.getTransaction().commit();
    }

    public List<DadosCompletosHospede> buscarPorSobrenome(String sobrenome) {
        if (sobrenome.length() < 3) {
            throw new RuntimeException("A busca deve conter pelo menos 3 caracteres");
        }

        if (!sobrenome.matches("[^\\p{M}\\p{S}\\p{P}\\p{C}]+")) {
            throw new RuntimeException("A busca não permite caracteres especiais, por favor tente novamente!");
        }

        return hospedeDAO.buscarPorSobrenome(sobrenome)
                .stream()
                .map(DadosCompletosHospede::new)
                .toList();
    }

    public List<DadosCompletosHospede> buscarTodos() {
        return hospedeDAO.buscarAll()
                .stream()
                .map(DadosCompletosHospede::new)
                .toList();
    }

    public void editarHospede(Long id, DadosHospede dados) {
        Hospede hospede = hospedeDAO.buscarPorID(id);
        this.entityManager.getTransaction().begin();
        hospede.atualizarDados(dados);
        this.entityManager.getTransaction().commit();
    }

    public void deletarHospede(Long id) {
        Hospede hospede = hospedeDAO.buscarPorID(id);
        this.entityManager.getTransaction().begin();
        hospedeDAO.deletarHospede(hospede);
        this.entityManager.getTransaction().commit();
    }
}
