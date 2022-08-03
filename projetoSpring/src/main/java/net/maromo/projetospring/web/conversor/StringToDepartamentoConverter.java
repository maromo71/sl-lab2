package net.maromo.projetospring.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import net.maromo.projetospring.domain.Departamento;
import net.maromo.projetospring.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {
	
	private final DepartamentoService service;

	public StringToDepartamentoConverter(DepartamentoService service) {
		this.service = service;
	}

	@Override
	public Departamento convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
