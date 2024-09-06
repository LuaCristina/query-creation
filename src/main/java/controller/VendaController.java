package controller;
import model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.VendaService;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/sem-desconto")
    public List<Venda> getVendasSemDesconto() {
        return vendaService.findAllWithoutDiscount();
    }

    @GetMapping("/com-desconto")
    public List<Venda> getVendasComDesconto() {
        return vendaService.findAllWithDiscount();
    }

    @GetMapping("/ordenadas-por-valor")
    public List<Venda> getVendasOrdenadasPorValor() {
        return vendaService.findAllOrderedByValueDesc();
    }

}
