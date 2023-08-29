import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
package br.com.pizzaria.dto;public class EnderecoDTO {

package br.com.pizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
    private String rua;
    private String cidade;
    private String estado;
}
