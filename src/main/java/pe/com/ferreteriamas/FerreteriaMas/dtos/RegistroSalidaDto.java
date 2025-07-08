package pe.com.ferreteriamas.FerreteriaMas.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.ferreteriamas.FerreteriaMas.model.DetalleSalidaEntity;
import pe.com.ferreteriamas.FerreteriaMas.model.RegistroSalidaEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroSalidaDto {

    private RegistroSalidaEntity registroSalida;
    private List<DetalleSalidaEntity> detalleSalida;
}
