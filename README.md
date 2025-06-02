Todo o beckend esta pronto, e conta com as seguintes funiconalidades:
Criar Perfil
Adicionar amigos
Remover amigos
Adicionar album favorito
Remover album favorito
Todas as informações são salvas juntas com o perfil em um JSON




O Token de acesso do spotify deve ser atualizado por meio do postman para testes
1. Criar uma nova requisição POST
URL:
https://accounts.spotify.com/api/token
2. Na aba Authorization
Tipo: Basic Auth

User: 3dc17cfaa0154f9491840fb373825809

Password: 56e4485b1c234e4d97c4e0f9f9b32f22

(Postman vai gerar o header Authorization: Basic ... automaticamente)

3. Na aba Body
Selecione x-www-form-urlencoded

Adicione o par chave/valor:

grant_type = client_credentials

4. Clique em Send
5. Resultado esperado
Você vai receber uma resposta JSON com o token:
json
{
  "access_token": "BQDxxxyyyZZZ...",
  "token_type": "Bearer",
  "expires_in": 3600
}
