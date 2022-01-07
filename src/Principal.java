import java.util.ArrayList;
import java.util.Scanner;
public class Principal {
	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);
		int linha = 0, coluna = 0, cod = 0, opcao, codFilme, codSessao, idCliente = 1, fileira, poltrona, varMenu = 1;
		String nomeFilme, nomeCliente;
		double valorPago;
		Cliente [][] lug = null;
		
		Atendente bruna = new Atendente(1, "Bruna");
		Atendente maria = new Atendente(2, "Maria");
		ArrayList<Atendente> atendentes = new ArrayList<Atendente>();
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		ArrayList<Sala> salas = new ArrayList<Sala>();
		
		// adicionamos as donas Maria e Bruna, principais atendentes.
		atendentes.add(maria);
		atendentes.add(bruna);
		
		
		
		boolean login = false;
		while(login == false) {
			
			login = true;
			
			System.out.println();
			System.out.print("Insira seu código de Atendente (1 ou 2 para primeiro acesso): ");
			cod = Integer.parseInt(leitura.nextLine());
			
			//Atendente atual = new Atendente(); não entendi pra que
			for(Atendente att : atendentes) {
				if(cod == att.getCodigoAtendente()) {
					//atual = a;
					
					System.out.println();
					System.out.print("Entre com o número de fileiras da Sala 1: ");
					linha = Integer.parseInt(leitura.nextLine());
					System.out.print("Entre com o número de poltronas por fileira da Sala 1: ");
					coluna = Integer.parseInt(leitura.nextLine());
					Cliente novaSala1 [][] = new Cliente[linha][coluna];
					Sala sala1 = new Sala(1, novaSala1, 1, (linha*coluna));
					salas.add(sala1);
					
					System.out.println();
					System.out.print("Entre com o número de fileiras da Sala 2: ");
					linha = Integer.parseInt(leitura.nextLine());
					System.out.print("Entre com o número de poltronas por fileira da Sala 2: ");
					coluna = Integer.parseInt(leitura.nextLine());
					Cliente novaSala2 [][] = new Cliente[linha][coluna];
					Sala sala2 = new Sala(2, novaSala2, 2, (linha*coluna));
					salas.add(sala2);
					
					// adicionando filmes para testar (abaixo) - 17h, 19h30 e 22h
					
					String [] elenco = new String[3];

					elenco[0] ="Emma Stone";
					elenco[1] ="Emma Thompson"; 
					elenco[2] ="Emily Beecham"; 
					Filme filme1 = new Filme(1, "Cruella" ,elenco, 2021, "Inteligente, criativa e determinada, Estella quer fazer um nome para si através de seus "
							+ "designs e acaba chamando a atenção da Baronesa Von Hellman. Entretanto, o relacionamento delas desencadeia um curso de eventos "
							+ "e revelações que fazem com que Estella abrace seu lado rebelde e se torne a Cruella, uma pessoa má, elegante e voltada para a vingança.",
							"Comédia", cod);
					filmes.add(filme1);
					
					elenco[0] ="Patrick Wilson";
					elenco[1] ="Vera Farmiga"; 
					elenco[2] ="Ron Livingston"; 
					Filme filme2 = new Filme(2, "2012" ,elenco, 2009, "Bilhões de habitantes da Terra não estão cientes de que o planeta tem uma data de expiração. "
							+ "Com os avisos de um cientista norte-americano, os líderes mundiais começam os preparativos secretos para a sobrevivência de alguns "
							+ "membros da sociedade. Quando o cataclisma global finalmente ocorre, o fracassado escritor Jackson Curtis tenta levar sua família "
							+ "para um lugar seguro quando o mundo começa a desmoronar.",
							"Ação/Ficção científica", cod);
					filmes.add(filme2);
					
					Sessao sessao1 = new Sessao(1, sala1, filmes.get(0), "17h");
					Sessao sessao2 = new Sessao(2, sala2, filmes.get(1), "17h");
					Sessao sessao3 = new Sessao(3, sala1, filmes.get(0), "19h30");

					sessoes.add(sessao1);
					sessao1.getFilme().verificaCartaz(sessoes);
					sessoes.add(sessao2);
					sessao2.getFilme().verificaCartaz(sessoes);
					sessoes.add(sessao3);
					sessao3.getFilme().verificaCartaz(sessoes);
					
					// vamos começar a trabalhar agora 
					
					while(varMenu != 0) {
						
						menu();
						System.out.print("Entre com um número: ");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
						// opcao 1 Menu Principal
						case 1:
							System.out.println("Você selecionou Vendas de ingressos!");
							System.out.println();
							System.out.print("Entre com o nome do filme: ");
							nomeFilme = leitura.nextLine();
							System.out.println();
							
							for(Filme f : filmes) {
								if(f.getTitulo().contains(nomeFilme) && f.isEmCartaz()) {
									System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("Código: "+f.getCodigo()+" | "+"Filme: "+f.getTitulo()+" | "+"Código do Atendente: "+f.getCodAtendente());
									System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
								}
							}
							
							System.out.println();
							System.out.print("Entre com o código do filme: ");
							codFilme = Integer.parseInt(leitura.nextLine());
							System.out.println();
							
							System.out.println();
							System.out.println("Sessões disponíveis: ");
							System.out.println();
							for(Sessao s : sessoes) {
								if(s.getFilme().getCodigo() == codFilme) {
									System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("Código da Sessão: "+s.getCodigoSessao()+" | "+"Sala: "+s.getSala().getCodigoSala()+" | "+"Horário: "+s.getHorario()+" | "+"Filme: "+s.getFilme().getTitulo());
									System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
								}
							}
							
							System.out.println();
							System.out.print("Entre com o código da sessão: ");
							codSessao = Integer.parseInt(leitura.nextLine());
							
							System.out.println();
							System.out.print("Entre com o nome do Cliente: ");
							nomeCliente = leitura.nextLine();
							System.out.println();
							System.out.print("Entre com o valor pago: ");
							valorPago = Double.parseDouble(leitura.nextLine());
							Cliente cliente = new Cliente(1, nomeCliente, valorPago);
							idCliente++;
							
							System.out.println();
							System.out.println("Lugares Livres:");
							System.out.println();
							
							for(Sessao s : sessoes) {
								
									
								if(s.getCodigoSessao() == codSessao) {
										
									s.getSala().toString();
									lug = s.getSala().getLugares();
										
									int temp = 0;
									while(temp == 0) {
										System.out.println();
										System.out.print("Entre com a fileira que deseja sentar: ");
										fileira = Integer.parseInt(leitura.nextLine());
											
										System.out.println();
										System.out.print("Entre com a coluna que deseja sentar: ");
										poltrona = Integer.parseInt(leitura.nextLine());
											
										if(s.getSala().verificaLugar(fileira, poltrona)) {
											lug[fileira][poltrona] = cliente;
											s.getSala().setLugares(lug);
											temp = 1;
											System.out.println();
											System.out.println("Ingresso vendido com sucesso!");
										} else {
											System.out.println();
											System.out.println("Poltrona ocupada!!");
											System.out.print("Digite 0 para tentar novamente ou qualquer número para sair: ");
											temp = Integer.parseInt(leitura.nextLine());
										}
									}
										
								}
								
								
							}
							break;
						// opcao 2 Menu Principal
						case 2:
							
							System.out.println();
							System.out.println("Você selecionou Gerenciamento de filmes!");
							
							int opcaoFilmes = 0; 
							while(opcaoFilmes != 6) {
								
								menuFilme();
								System.out.println();
								System.out.print("Entre com um número: ");
								opcaoFilmes = Integer.parseInt(leitura.nextLine());
								
								switch(opcaoFilmes) {
								
								case 1:
									
									System.out.println();
									System.out.println("Filmes cadastrados na plataforma");
									for(Filme f : filmes) {
										System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
										System.out.println("Código: "+f.getCodigo()+" | "+"Filme: "+f.getTitulo()+" | "+"Código do Atendente: "+f.getCodAtendente());
										System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
									}
									break;
									
								case 2:
									
									System.out.println();
									System.out.println("Filmes em Cartaz");
									for(Filme f : filmes) {
										if(f.isEmCartaz()) {
											System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
											System.out.println("Código: "+f.getCodigo()+" | "+"Filme: "+f.getTitulo()+" | "+"Código do Atendente: "+f.getCodAtendente());
											System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
										}
									}
									break;
									
								case 3:
									
									int codigo=0, anoLancamento, qtdeElenco;
									boolean varCodFilme = false;
									String titulo, sinopse, genero;
								
									
									System.out.println();
									System.out.println("Cadastro de Filme");
									System.out.println();
									
									while(varCodFilme == false) {
										varCodFilme = true;
										System.out.print("Código: ");
										codigo = Integer.parseInt(leitura.nextLine());
										for(Filme f : filmes) {
											if(f.getCodigo() == codigo) {
												System.out.println("Código já cadastrado! Tente novamente.");
												varCodFilme = false;
											}
										}
									}
									
									System.out.println();
									System.out.print("Título: ");
									titulo = leitura.nextLine();
									System.out.println();
									System.out.print("Entre com a quantidade de pessoas do elenco: ");
									qtdeElenco = Integer.parseInt(leitura.nextLine());
									
									String[] elencoFilme = new String[qtdeElenco];
									for(int i = 0; i < qtdeElenco; i++) {
										System.out.println();
										System.out.print("Entre com o nome de uma pessoa do elenco: ");
										elencoFilme[i] = leitura.nextLine();
									}
						
									System.out.println();
									System.out.print("Entre com o ano de lançamento: ");
									anoLancamento = Integer.parseInt(leitura.nextLine());
									System.out.println();
									System.out.print("Sinopse: ");
									sinopse = leitura.nextLine();
									System.out.println();
									System.out.print("Gênero: ");
									genero = leitura.nextLine();
									
									Filme filme = new Filme(codigo, titulo, elenco, anoLancamento, sinopse, genero, cod);
									filmes.add(filme);
									break;
								
								case 4:
									
									System.out.println();
									System.out.println("Você selecionou gereciamento de sessões!");
									System.out.println();
									
									int opcaoSessao = 0;
									
									while(opcaoSessao != 4) {
										
										menuSessoes();
										System.out.println();
										System.out.print("Entre com um número: ");
										opcaoSessao = Integer.parseInt(leitura.nextLine());
										
										switch(opcaoSessao) {
										case 1:
											
											System.out.println();
											System.out.println("Sessões");
											System.out.println();
											
											for(Sessao s: sessoes) {
												System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
												System.out.println("Código da Sessão: "+s.getCodigoSessao()+" | "+"Sala: "+s.getSala().getCodigoSala()+" | "+"Horário: "+s.getHorario()+" | "+"Filme: "+s.getFilme().getTitulo());
												System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
											}
											break;
										
										case 2:
											
											int codigoSessao = 0, opcaoSala, opcaoFilme;
											Sala sala = null;
											Filme filmeSessao = null;
											String horario = null;
											boolean varCodSessao = false;
											
											System.out.println();
											System.out.println("Cadastrar nova sessão");
											System.out.println();
											
											while(varCodSessao == false) {
												varCodSessao = true;
												System.out.print("Código: ");
												codigoSessao = Integer.parseInt(leitura.nextLine());
												for(Sessao s : sessoes) {
													if(s.getCodigoSessao() == codigoSessao) {
														System.out.println("Código já cadastrado! Tente novamente.");
														varCodSessao = false;
													}
												}
											}
											
											System.out.println();
											System.out.println("Salas disponíveis: ");
											System.out.println();
											for(Sala sa : salas) {
												System.out.println("---------------------------------------------");
												System.out.println("Sala: "+sa.getCodigoSala());
												System.out.println("----------------------------------------------");
											}
											
											System.out.println();
											System.out.print("Entre com o código da sala: ");
											opcaoSala = Integer.parseInt(leitura.nextLine());
											
											System.out.println();
											System.out.println("Filmes disponíveis: ");
											for(Filme f : filmes) {
												System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
												System.out.println("Código: "+f.getCodigo()+" | "+"Filme: "+f.getTitulo());
												System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
											}
											
											System.out.println();
											System.out.print("Entre com o código do filme: ");
											opcaoFilme = Integer.parseInt(leitura.nextLine());
											
											
											int escolhaHor = 1;
											while(escolhaHor != 0) {
												escolhaHor = 0;
												
												int opcaoHor = 0;
												System.out.println();
												System.out.print("""
														Horários disponíveis
														
														1. 17h
														2. 19h30
														3. 22h
														
														Entre com uma opção:""");
												opcaoHor = Integer.parseInt(leitura.nextLine());

												switch(opcaoHor) {
												
												case 1:
													horario = "17h";
													break;
												case 2:
													horario = "19h30";
													break;
												case 3:
													horario = "22h";
													break;
												}
												
												for(Sessao s : sessoes) {
													if(s.getHorario().equals(horario) && s.getSala().getCodigoSala() == opcaoSala) {
														System.out.println("Esse horário já foi cadastro nesta sala");
														System.out.print("Digite qualquer número para tentar novamente ou 0 para sair.");
														escolhaHor = Integer.parseInt(leitura.nextLine());
														horario = null;
													}
												}
											}
											
											
											for(Sala sa : salas) {
												if(opcaoSala == sa.getCodigoSala()) {
													sala = sa;
												}
											}
											
											for(Filme f : filmes) {
												if(opcaoFilme == f.getCodigo()) {
													filmeSessao = f;
												}
											}
											
											if(horario != null) {
												Sessao sessao = new Sessao(codigoSessao, sala, filmeSessao, horario);
												sessoes.add(sessao);
												filmeSessao.verificaCartaz(sessoes);
											}
											
											break;
											
										// opcao 3 remover sessão
										case 3:
											
											System.out.println();
											System.out.println("Sessões");
											System.out.println();
											
											for(Sessao s: sessoes) {
												System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
												System.out.println("Código da Sessão: "+s.getCodigoSessao()+" | "+"Sala: "+s.getSala().getCodigoSala()+" | "+"Horário: "+s.getHorario()+" | "+"Filme: "+s.getFilme().getTitulo());
												System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
											}
											
											int codRemoveSessao = 0;
											System.out.println();
											System.out.print("Insira o código da sessão que deseja remover: ");
											codRemoveSessao = Integer.parseInt(leitura.nextLine());
											
											for(Sessao s : sessoes) {
												if(s.getCodigoSessao() == codRemoveSessao){
													sessoes.remove(s);
													s.getFilme().verificaCartaz(sessoes);
													break;
												}
											}

											break; // break opcao 3 remover sessão
											
										// opcao sair do Gerenciamento de Sessoes
										case 4:
											opcaoSessao = 4;
											break;
										}	
										
									}
									// break opcao 4 gerenciamento de filme
									break;
								
								// opcao 5 gerenciamento de filme
								case 5:
									int codRemoveFilme = 0;
									
									System.out.println();
									System.out.println("Você selecionou a opção de remover um filme em cartaz");
									System.out.println();
									
									System.out.println();
									System.out.println("Filmes em Cartaz");
									for(Filme f : filmes) {
										if(f.isEmCartaz()) {
											System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
											System.out.println("Código: "+f.getCodigo()+" | "+"Filme: "+f.getTitulo());
											System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
										}
									}
									
									System.out.print("Entre com o código do filme que deseja tirar de cartaz: ");
									codRemoveFilme = Integer.parseInt(leitura.nextLine());
									
									for(Filme f : filmes) {
										if(f.getCodigo() == codRemoveFilme) {
											f.setEmCartaz(false);
										}
									}
									
									for(Sessao s : sessoes) {
										if(s.getFilme().getCodigo() == codRemoveFilme){
											sessoes.remove(s);
											break;
										}
									}
									
									break;// break opcao 5 gerenciamento de filme
								
								// opcao 6 gerenciamento de filme
								case 6:
									opcaoFilmes = 6;
									break;// break opcao 6 gerenciamento de filme
									
								}
							
							}
							
							break;// break opcao 2 menu Principal

						// opcao 3 menu Principal gereciamento de salas
						case 3:
							
							System.out.println();
							int escolhaSala = 0;
							while(escolhaSala != 5) {
								
								menuSalas();
								escolhaSala = Integer.parseInt(leitura.nextLine());
								
								// escolha do menuSalas()
								switch(escolhaSala) {
								
								// Ver todas as salas:
								case 1:
									System.out.println();
									System.out.println("Você selecionou ver todas as salas");
									System.out.println();
									
									System.out.println();
									System.out.println("Salas existentes: ");
									System.out.println();
									for(Sala sa : salas) {
										System.out.println("----------------------------------------------------------------------------------------------------------------");
										System.out.println("Sala: "+sa.getCodigoSala()+" | "+"Número de Lugares: "+sa.getNumLugares()+" | "+"Tipo da sala: "+sa.getTipoSala());
										System.out.println("----------------------------------------------------------------------------------------------------------------");
									}
									
									break; // break do caso 1 menuSalas()
									
								// Cadastrar nova sala:
								case 2:
									int codigoSala = 0, tipoSala = 0;
									boolean varCodSala = false;
									
									System.out.println();
									System.out.println("Você selecionou cadastrar nova sala");
									System.out.println();
									
									
									while(varCodSala == false) {
										varCodSala = true;
										System.out.println();
										System.out.print("Entre com o código da Sala: ");
										codigoSala = Integer.parseInt(leitura.nextLine());
										for(Sala sa : salas) {
											if(sa.getCodigoSala() == codigoSala) {
												System.out.println("Código já cadastrado! Tente novamente.");
												varCodSala = false;
											}
										}
									}
									
									System.out.println();
									System.out.print("Entre com o tipo da Sala: ");
									tipoSala = Integer.parseInt(leitura.nextLine());
								
									System.out.println();
									System.out.print("Entre com o número de fileiras da nova Sala: ");
									linha = Integer.parseInt(leitura.nextLine());
									System.out.println();
									System.out.print("Entre com o número de poltronas por fileira da nova Sala: ");
									coluna = Integer.parseInt(leitura.nextLine());
									
									Cliente novaSala [][] = new Cliente[linha][coluna];
									Sala sala = new Sala(codigoSala, novaSala, tipoSala, (linha*coluna));
									salas.add(sala);

									break; // break do caso 2 menuSalas()
									
								// Remover uma sala:
								case 3:
									int codSala = 0;
									System.out.println();
									System.out.println("Você selecionou ver remover uma sala");
									System.out.println();
									
									System.out.println();
									System.out.println("Salas disponíveis: ");
									System.out.println();
									for(Sala sa : salas) {
										System.out.println("----------------------------------------------------------------------------------------------------------------");
										System.out.println("Sala: "+sa.getCodigoSala()+" | "+"Número de Lugares: "+sa.getNumLugares()+" | "+"Tipo da sala: "+sa.getTipoSala());
										System.out.println("----------------------------------------------------------------------------------------------------------------");
									}
									
									System.out.println();
									System.out.print("Entre com o código da Sala: ");
									codSala = Integer.parseInt(leitura.nextLine());
									
									for(Sala sa : salas) {
										if(sa.getCodigoSala() == codSala) {
											salas.remove(sa);
											System.out.println();
											System.out.println("Sala removida com sucesso!");
											System.out.println();
											break;
										}
									}
									
									break; // break do caso 3 menuSalas()
									
								// Atualizar uma sala:
								case 4:
									
									int codSalaAtt = 0;
									System.out.println();
									System.out.println("Você selecionou atualizar uma sala");
									System.out.println();
									
									System.out.println();
									System.out.println("Salas disponíveis: ");
									System.out.println();
									for(Sala sa : salas) {
										System.out.println("----------------------------------------------------------------------------------------------------------------");
										System.out.println("Sala: "+sa.getCodigoSala()+" | "+"Número de Lugares: "+sa.getNumLugares()+" | "+"Tipo da sala: "+sa.getTipoSala());
										System.out.println("----------------------------------------------------------------------------------------------------------------");
									}
									
									System.out.println();
									System.out.print("Entre com o código da Sala: ");
									codSalaAtt = Integer.parseInt(leitura.nextLine());
									
									for(Sala sa : salas) {
										if(sa.getCodigoSala() == codSalaAtt) {
											
											System.out.println();
											System.out.print("Entre com o tipo da Sala: ");
											tipoSala = Integer.parseInt(leitura.nextLine());
										
											System.out.println();
											System.out.print("Entre com o número de fileiras da nova Sala: ");
											linha = Integer.parseInt(leitura.nextLine());
											System.out.println();
											System.out.print("Entre com o número de poltronas por fileira da nova Sala: ");
											coluna = Integer.parseInt(leitura.nextLine());
											
											Cliente attSala [][] = new Cliente[linha][coluna];
											sa.setTipoSala(tipoSala);
											sa.setNumLugares(linha*coluna);
											sa.setLugares(attSala);
											
											System.out.println("Sala atualizada com sucesso!");
										}
									}
									
									break; // break do caso 4 menuSalas()
									
								// Sair:
								case 5:
									escolhaSala = 5;
									break; // break do caso 5 menuSalas()
									
								} // fim switch menuSalas()
								
							}
							
							break;// break opcao 3 menu Principal
						
						// opcao 4 menu Principal gereciamento de atendentes
						case 4:
							
							System.out.println();
							System.out.println("Você selecionou Gereciamento de Atendentes");
							System.out.println();
							
							int opcaoAtt = 0;
							while(opcaoAtt != 4) {
								
								menuAtendentes();
								opcaoAtt = Integer.parseInt(leitura.nextLine());
								
								switch(opcaoAtt) {
								
								// opcao 1 menuAtendentes()
								case 1:
									System.out.println();
									System.out.println("Você selecionou ver Atendentes");
									System.out.println();
									
									for(Atendente a : atendentes) {
										System.out.println("----------------------------------------------------------------------------------------------------------------");
										System.out.println("Código Atendente: "+a.getCodigoAtendente()+" | "+"Nome: "+a.getNome());
										System.out.println("----------------------------------------------------------------------------------------------------------------");
									}
									break;// break opcao 1 menuAtendentes()
								
								// opcao 2 menuAtendentes()
								case 2:
									
									int codigoAtt = 0;
									String nomeAtt = null;
									boolean varCodAtt = false;
									
									System.out.println();
									System.out.println("Você selecionou Cadastro de um Atendente");
									System.out.println();
									
									while(varCodAtt == false) {
										varCodAtt = true;
										System.out.println();
										System.out.print("Entre com o código do Atendente: ");
										codigoAtt = Integer.parseInt(leitura.nextLine());
										for(Atendente a : atendentes) {
											if(a.getCodigoAtendente() == codigoAtt) {
												System.out.println("Código já cadastrado! Tente novamente.");
												varCodAtt = false;
											}
										}
									}
									
									System.out.println();
									System.out.print("Entre com o nome do Atendente: ");
									nomeAtt = leitura.nextLine();
									
									Atendente atendente = new Atendente(codigoAtt, nomeAtt);
									atendentes.add(atendente);
									
									break;// break opcao 2 menuAtendentes()
								
								// opcao 3 menuAtendentes()
								case 3:
									System.out.println();
									System.out.println("Você selecionou remover um Atendente");
									System.out.println();
									
									System.out.println();
									System.out.println("Atendentes disponíveis");
									System.out.println();
									
									for(Atendente a : atendentes) {
										System.out.println("----------------------------------------------------------------------------------------------------------------");
										System.out.println("Código Atendente: "+a.getCodigoAtendente()+" | "+"Nome: "+a.getNome());
										System.out.println("----------------------------------------------------------------------------------------------------------------");
									}
									
									System.out.println();
									System.out.print("Entre com o cógido do Atendente: ");
									codigoAtt = Integer.parseInt(leitura.nextLine());
									
									for(Atendente a : atendentes) {
										if(a.getCodigoAtendente() == codigoAtt) {
											atendentes.remove(a);
											System.out.println();
											System.out.print("Atendente removido do sistema.");
											System.out.println();
											break;
										}
									}
									
									break;// break opcao 3 menuAtendentes()

									
								}// fim switch
								
							}// fim do while
							
							break;// break opcao 4 menu Principal
							
						// opcao 5 menu Principal financeiro
						case 5:
							
							System.out.println();
							System.out.println("Você selecionou financeiro");
							System.out.println();
							
							int opcaoFin = 0;
							while(opcaoFin != 5) {
								
								
								menuFinanceiro();
								opcaoFin = Integer.parseInt(leitura.nextLine());
								
								switch(opcaoFin) {
								
								// opcao 1 menuFinanceiro()
								case 1:
									System.out.println();
									System.out.println("Você selecionou faturamento por sala.");
									System.out.println();
									
									for(Sala sa : salas) {
										double valor = 0;
										System.out.println();
										System.out.println("Sala: "+sa.getCodigoSala());
										for(Sessao s : sessoes) {
											if(s.getSala().getCodigoSala() == sa.getCodigoSala()) {
												for(int i = 0; i < s.getSala().getLugares().length; i++) {
													for(int j = 0; j < s.getSala().getLugares()[i].length; j++) {
														if(s.getSala().getLugares()[i][j] != null) {
															valor+= s.getSala().getLugares()[i][j].getValorPago();
														}
													}
													
												}
											}
										}
										System.out.println("Faturamento total R$"+valor);
										System.out.println();
									}
									break;// break opcao 1 menuFinanceiro()
									
								// opcao 2 menuFinanceiro()
								case 2:
									
									System.out.println();
									System.out.println("Você selecionou faturamento por horário.");
									System.out.println();
									
									double valorHorario17 = 0;
									System.out.println();
									System.out.println("Horário: 17h");
									for(Sessao s : sessoes) {
										if(s.getHorario().equals("17h")) {
											for(int i = 0; i < s.getSala().getLugares().length; i++) {
												for(int j = 0; j < s.getSala().getLugares()[i].length; j++) {
													if(s.getSala().getLugares()[i][j] != null) {
														valorHorario17+= s.getSala().getLugares()[i][j].getValorPago();
													}
												}
													
											}
										}
									}
									System.out.println("Faturamento total R$"+valorHorario17);
									System.out.println();
									
									System.out.println();
									System.out.println("Horário: 19h30");
									double valorHorario19 = 0;
									for(Sessao s : sessoes) {
										if(s.getHorario().equals("19h30")) {
											for(int i = 0; i < s.getSala().getLugares().length; i++) {
												for(int j = 0; j < s.getSala().getLugares()[i].length; j++) {
													if(s.getSala().getLugares()[i][j] != null) {
														valorHorario19+= s.getSala().getLugares()[i][j].getValorPago();
													}
												}
													
											}
										}
									}
									System.out.println("Faturamento total R$"+valorHorario19);
									System.out.println();
									
									System.out.println();
									System.out.println("Horário: 22h");
									double valorHorario22 = 0;
									for(Sessao s : sessoes) {
										if(s.getHorario().equals("22h")) {
											for(int i = 0; i < s.getSala().getLugares().length; i++) {
												for(int j = 0; j < s.getSala().getLugares()[i].length; j++) {
													if(s.getSala().getLugares()[i][j] != null) {
														valorHorario22+= s.getSala().getLugares()[i][j].getValorPago();
													}
												}
													
											}
										}
									}
									System.out.println("Faturamento total R$"+valorHorario22);
									System.out.println();
									break; // break opcao 2 menuFinanceiro()
									
								//opcao 3 menuFinanceiro()
								case 3:
									System.out.println();
									System.out.println("Você selecionou faturamento por filme.");
									System.out.println();
									
									for(Filme f : filmes) {
										double valorFilme = 0;
										System.out.println();
										System.out.println("Filme: "+f.getTitulo());
										for(Sessao s : sessoes) {
											if(s.getFilme().getCodigo() == f.getCodigo()) {
												for(int i = 0; i < s.getSala().getLugares().length; i++) {
													for(int j = 0; j < s.getSala().getLugares()[i].length; j++) {
														if(s.getSala().getLugares()[i][j] != null) {
															valorFilme+= s.getSala().getLugares()[i][j].getValorPago();
														}
													}
													
												}
											}
										}
										System.out.println("Faturamento total R$"+valorFilme);
										System.out.println();
									}
									
									break;// break opcao 3 menuFinanceiro()
								
								// opcao 4 menuFinanceiro()
								case 4:
									
									System.out.println();
									System.out.println("Você selecionou faturamento geral.");
									System.out.println();
									
									double valorGeral = 0;
									for(Sessao s : sessoes) {
											for(int i = 0; i < s.getSala().getLugares().length; i++) {
												for(int j = 0; j < s.getSala().getLugares()[i].length; j++) {
													if(s.getSala().getLugares()[i][j] != null) {
														valorGeral+= s.getSala().getLugares()[i][j].getValorPago();
													}
												}
													
											}
									}
									System.out.println("Faturamento total R$"+valorGeral);
									System.out.println();
									
									break;// break opcao 4 menuFinanceiro()
									
								} // fim switch menufinanceiro()
								
								
								
							}// fim do while 
							
							break;// break opcao 5 menu Principal
						
						// opcao 6 menu principal
						case 6:
							varMenu = 0;
							login = true;
							break;// break opcao 6 menu Principal
						}
					}
					
				} else {
					login = false;
				}
			}// fim do for verificador do atendente inicial
			
		} // fim do while principal
		
		
		
		
	} // colchete da principal
	
	public static void menu() {
		System.out.print("""
				
							Cineminha da tropinha
				
				1. Vendas de ingressos;
				2. Gerenciamento de filmes;
				3. Gerenciamento de salas;
				4. Gerenciamento de atendentes;
				5. Financeiro;
				6. Sair;
				
				""");
	}
	
	public static void menuFilme() {
		System.out.print("""
				
						O que deseja fazer em Gerenciamento de filmes?
				
				1. Ver todos os filmes cadastrados no sistema;
				2. Ver filmes que estão em cartaz;
				3. Cadastrar um novo filme;
				4. Gerenciar sessões;
				5. Remover um filme de cartaz;
				6. Sair;
				
				""");
	}
	
	public static void menuSessoes() {
		System.out.print("""
				
						O que deseja fazer em Gerenciamento de Sessões?
				
				1. Ver todas as sessões;
				2. Cadastrar nova sessão;
				3. Remover uma sessão;
				4. Sair;
				
				""");
	}
	
	public static void menuSalas() {
		System.out.print("""
				
						O que deseja fazer em Gerenciamento de Sala?
				
				1. Ver todas as salas;
				2. Cadastrar nova sala;
				3. Remover uma sala;
				4. Atualizar uma sala;
				5. Sair;
				
				Entre com um número: """);
	}
	
	public static void menuAtendentes() {
		System.out.print("""
				
						O que deseja fazer em Gerenciamento de Atendentes?
				
				1. Ver todos atendentes;
				2. Cadastrar novo Atendente;
				3. Remover um atendente;
				4. Sair;
				
				Entre com um número:""");
	}
	
	public static void menuFinanceiro() {
		System.out.print("""
				
						O que deseja fazer no Financeiro?
				
				1. Consultar faturamento por sala;
				2. Consultar faturamento por horário;
				3. Consultar faturamento por filme;
				4. Consultar faturamento geral;
				5. Sair;
				
				Entre com um número: """);
	}

}
