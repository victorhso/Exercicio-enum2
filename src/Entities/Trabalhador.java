package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double salario;

	Departamento departamento;
	List<ContratoHora> contratos = new ArrayList<>();

	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}
	
	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}

	public void addContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}

	public void removeContrato(ContratoHora contrato) {
		contratos.remove(contrato);
	}

	public double ganho(int mes, int ano) {
		double soma = this.salario;
		Calendar calendario = Calendar.getInstance();
		for (ContratoHora x : contratos) {
			calendario.setTime(x.getDate());
			int calendario_mes = 1 + calendario.get(Calendar.MONTH);
			int calendario_ano = calendario.get(Calendar.YEAR);

			if (mes == calendario_mes && ano == calendario_ano) {
				soma += x.valorTotal();
			}
		}
		return soma;
	}
}