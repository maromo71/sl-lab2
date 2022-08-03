package net.maromo.projetospring.web.conversor;

import net.maromo.projetospring.domain.Cargo;
import net.maromo.projetospring.service.CargoService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

	private final CargoService service;


	public StringToCargoConversor(CargoService service) {
		this.service = service;
	}

	@Override
	public Cargo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
