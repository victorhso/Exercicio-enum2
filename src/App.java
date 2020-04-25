import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.ContratoHora;
import Entities.Departamento;
import Entities.Trabalhador;
import Entities.enums.NivelTrabalhador;

public class App {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);

		System.out.print("Entre com o nome do departamento: ");
		String nomeDep = sc.nextLine();
		System.out.print("--------------Entre com os dados do trabalhador--------------\n");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível (Júnior, Pleno, Sênior): ");
		String nivel = sc.nextLine();
		System.out.print("Salário base: R$");
		double salario = sc.nextDouble();
		System.out.println();
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), salario,
				new Departamento(nomeDep));

		System.out.print("Quantos contratos o trabalhador terá? \nContratos: ");
		int contratos = sc.nextInt();
		System.out.println("-------------------------------------------------------------");

		for (int i = 1; i <= contratos; i++) {
			System.out.print("Entre com o #" + i + " contrato\n");
			System.out.print("Data: ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: R$");
			Double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			ContratoHora contratoHora = new ContratoHora(data, valorHora, horas);
			trabalhador.addContrato(contratoHora);
			System.out.println("------------------------------------------------------------");
		}
		
		System.out.print("Entre com a data para calcular os ganhos do trabalhador (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.print("Nome: " + trabalhador.getNome());
		System.out.print("\nDepartamento: " + trabalhador.getDepartamento().getDepartamento());
		System.out.print("\nGanhos no mês " + mesAno + ": " + String.format("%.2f", trabalhador.ganho(mes, ano)));
		sc.close();
	}

}
