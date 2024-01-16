# API de Vaga

## Obter Lista de Vagas

### Requisição
- **Método:** GET
- **Endpoint:** `/vaga/obterLista`
- **Headers:** `sec` (Token de Autenticação)

### Resposta
- **Status de Sucesso:** 200 OK
- **Corpo da Resposta:** JSON contendo a lista de vagas disponíveis

## Obter Vaga por ID

### Requisição
- **Método:** GET
- **Endpoint:** `/vaga/obterPorId`
- **Headers:** `sec` (Token de Autenticação)
- **Parâmetros da Consulta:** `id` (ID da Vaga)

### Resposta
- **Status de Sucesso:** 200 OK
- **Corpo da Resposta:** JSON contendo os detalhes da vaga

## Manter Vaga (Criar/Atualizar)

### Requisição
- **Método:** POST
- **Endpoint:** `/vaga/manter`
- **Headers:** `sec` (Token de Autenticação)
- **Corpo da Requisição:** JSON contendo os detalhes da vaga a ser registrada ou atualizada

### Resposta
- **Status de Sucesso:** 200 OK
- **Corpo da Resposta:** JSON contendo os detalhes da vaga recém-criada ou atualizada

## Alterar Vaga

### Requisição
- **Método:** POST
- **Endpoint:** `/vaga/alterar`
- **Headers:** `sec` (Token de Autenticação)
- **Corpo da Requisição:** JSON contendo os detalhes da vaga a ser alterada

### Resposta
- **Status de Sucesso:** 200 OK
- **Corpo da Resposta:** JSON contendo os detalhes da vaga após a alteração

## Excluir Vaga

### Requisição
- **Método:** POST
- **Endpoint:** `/vaga/excluir`
- **Headers:** `sec` (Token de Autenticação)
- **Corpo da Requisição:** JSON contendo o ID da vaga a ser excluída

### Resposta
- **Status de Sucesso:** 200 OK
- **Corpo da Resposta:** JSON contendo uma mensagem de sucesso

---

## Modelos JSON

### VagaRecord
```json
{
  "id": "ID da Vaga",
  "titulo": "Título da Vaga",
  "descricao": "Descrição da Vaga",
  "requisitos": "Requisitos da Vaga"
}
```
### MensagemRetorno
```json
{
  "mensagem": "Mensagem de Retorno"
}

```