package br.com.pizzaria.entity;

import br.com.pizzaria.entity.enums.Status;
import br.com.pizzaria.entity.enums.Tamanho;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_pedido",schema = "public")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Tamanho tamanho;
    @ElementCollection
    private List<String> sabores;
    private boolean entregaNecessaria;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private Status status;

}
