package service;

import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VendaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAllWithoutDiscount() {
        return vendaRepository.findAll().stream()
                .filter(venda -> venda.getDesconto() == null)
                .collect(Collectors.toList());
    }

    public List<Venda> findAllWithDiscount() {
        return vendaRepository.findAll().stream()
                .filter(venda -> venda.getDesconto() != null)
                .collect(Collectors.toList());
    }

    public List<Venda> findAllOrderedByValueDesc() {
        return vendaRepository.findAll().stream()
                .sorted((v1, v2) -> Double.compare(v2.getValorUnit(), v1.getValorUnit()))
                .collect(Collectors.toList());
    }

    // Métodos para outras consultas serão adicionados aqui
}

