def menu() -> int:
    print("\nSeja bem-vindo ao Menu do +Voluntarios da Defesa Civil")
    print("Você deseja:")
    print("1) Criar um novo curso")
    print("2) Adicionar módulo a um curso")
    print("3) Criar avaliação para um curso")
    print("4) Cadastrar um novo voluntário")
    print("5) Pesquisar voluntário por CPF")
    print("6) Sair do sistema ")

    while True:
        try:
            opcao = int(input("Digite sua opção: "))
            if 1 <= opcao <= 6:
                return opcao
            else:
                print("Opção inválida. Digite uma opção entre 1 e 6")
        except ValueError:
            print("Entrada inválida. Por favor, digite um número entre 1 e 6")

def criar_voluntario(repositorio_voluntario: list):
    print("\n***************************************")
    print("Preenchendo dados pessoais do Voluntario")
    print("***************************************")
    nome_voluntario = input("Digite nome completo do voluntário: ")
    data_nascimento = input("Digite a data de nascimento do voluntário: ")
    cpf = ""
    while True:
        cpftentativa = input("Digite o CPF do paciente (apenas números): ")
        if len(cpftentativa) == 11 and cpftentativa.isdigit():
            cpf = cpftentativa
            break
        else:
            print("CPF inválido. Digite 11 dígitos válidos para o documento.")

    telefone = input("Digite o telefone do voluntário: ")
    email = input("Digite o e-mail do voluntário: ")
    habilidade = input("Digite qual é a sua habilidade que poderia auxiliar a comunidade em um desastre? ")
    ocupacao = input("Digite qual a sua ocupação: ")

    voluntario = [nome_voluntario, data_nascimento, cpf, telefone, email, habilidade,ocupacao]
    repositorio_voluntario.append(voluntario)
    print(f"\nVoluntário {nome_voluntario} cadastrado com sucesso!")


def criar_curso (repositorio_curso: list):
    print("\n*************************************")
    print("Criando um novo curso")
    print("**************************************")
    nome_curso = input("Digite o nome para o novo curso: ")

    for curso in repositorio_curso:
        if curso[0].lower() == nome_curso.lower():
            print("O curso que você está tentando cadastrar já existe!")
            return
    descricao_curso = input("De uma breve descrição para o curso: ")
    carga_horaria = int(input("Insira a carga horária do curso (entre 20 a 40 horas) com apenas números: "))

    novo_curso = [nome_curso, descricao_curso, carga_horaria,[],[]]
    repositorio_curso.append(novo_curso)
    print(f"\nCurso {nome_curso} criado com sucesso!")


def criar_modulo (repositorio_curso: list):
    print("\n*************************************")
    print("Adicionando Modulo a um curso")
    print("*************************************")

    nome_curso_busca = input("Digite o nome do curso ao qual este módulo pertence: ")
    curso_encontrado = None
    for curso in repositorio_curso:
        if curso[0].lower() == nome_curso_busca.lower():
            curso_encontrado = curso
            break

    if not curso_encontrado:
        print("\nO curso que você procurou não existe, crie primeiro um curso para adicionar o módulo.")
        return

    nome_modulo = input("Digite o nome do módulo: ")
    conteudo_texto = input("Digite o texto introdutório do módulo: ")
    video_url = input("Insira a URL do vídeo do módulo: ")

    modulo = [nome_modulo, conteudo_texto, video_url]
    curso_encontrado[3].append(modulo)

    print(f"\nMódulo {nome_modulo} criado com sucesso para o curso {curso_encontrado[0]}!")


def criar_avaliacao(repositorio_avaliacao: list, repositorio_cursos: list):
    print("\n*************************************")
    print("   Criação de uma nova Avaliação")
    print("**************************************")

    nome_curso_busca = input("Digite o nome do curso para esta avaliação: ")
    curso_encontrado = None
    for curso in repositorio_cursos:
        if curso[0].lower() == nome_curso_busca.lower():
            curso_encontrado = curso
            break

    if not curso_encontrado:
        print(f"O curso que você procurou não existe, crie primeiro um curso para adicionar o módulo.")
        return

    questoes = []
    for i in range (3):
        print(f"Pergunta {i + 1} de 3")
        pergunta = input("Digite o enunciado da pergunta: ")
        alternativa_a = input("Alternativa A: ")
        alternativa_b = input("Alternativa B: ")
        alternativa_c = input("Alternativa C: ")
        alternativa_d = input("Alternativa D: ")

        alternativa_correta = ""
        alternativa_correta = input("Letra da alternativa correta A, B, C ou D: ").lower()
        while alternativa_correta not in 'abcd':
            alternativa_correta = input("Opção inválida. Digite apenas A, B, C ou D: ").lower()
        questoes.append([pergunta, alternativa_a, alternativa_b, alternativa_c, alternativa_d, alternativa_correta])


    avaliacao = [curso_encontrado[4], questoes]
    repositorio_avaliacao.append(avaliacao)

    print(f"A avaliação com foi feita com sucesso para o curso {curso_encontrado[0]}!")

def exibir_voluntario(repositorio_voluntario: list, cpf: str):
    voluntario_encontrado = None
    for voluntario in repositorio_voluntario:
        if voluntario[2] == cpf:
            voluntario_encontrado = voluntario
            break

    if not voluntario_encontrado:
        print(f"Voluntário com CPF {cpf} não encontrado.")
        return

    print(f"Detalhes do Voluntário: {voluntario_encontrado[0]}")
    opcao = input("1) Visualizar dados pessoais 2) Realizar módulo e avaliação do curso inscrito (a implementar) \nEscolha uma opção: ")

    if opcao == "1":
        print("\nDados Pessoais do Voluntário:")
        print(f"Nome: {voluntario_encontrado[0]}")
        print(f"Data de Nascimento: {voluntario_encontrado[1]}")
        print(f"CPF: {voluntario_encontrado[2]}")
        print(f"Telefone: {voluntario_encontrado[3]}")
        print(f"E-mail: {voluntario_encontrado[4]}")
        print(f"Habilidade: {voluntario_encontrado[5]}")
        print(f"Ocupação: {voluntario_encontrado[6]}")
    elif opcao == "2":
        print("A ser implementado")

    else:
        print("Opção inválida, Por favor entre as opções 1 ou 2.")



voluntarios = []
cursos = []
avaliacoes = []
opcao = 0

while opcao != 6:
    opcao = menu()
    if opcao == 1:
        criar_curso(cursos)
    elif opcao == 2:
        criar_modulo(cursos)
    elif opcao == 3:
        criar_avaliacao(avaliacoes, cursos)
    elif opcao == 4:
        criar_voluntario(voluntarios)
    elif opcao == 5:
        cpf = input("\nDigite o CPF do voluntário que deseja procurar no sistema: ")
        exibir_voluntario(voluntarios, cpf)
    elif opcao == 6:
        print("Obrigado por utilizar o programa +Voluntarios da Defesa Civil!")
