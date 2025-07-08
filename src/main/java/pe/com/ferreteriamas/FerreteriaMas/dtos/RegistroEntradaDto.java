package pe.com.ferreteriamas.FerreteriaMas.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleEntradaEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroEntradaEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEntradaDto {

    private RegistroEntradaEntity registroEntrada;
    private List<DetalleEntradaEntity> detalleEntrada;

}
