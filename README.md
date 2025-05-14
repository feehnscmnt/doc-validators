# DOC-Validators
API para validação de documentos pessoais.

# Requisições
Para gerar o token de autorização das requisições: POST <a href="#">/doc-validators/token?username={username}</a>
<br>
Para validar números de telefone: GET <a href="#">/doc-validators/validate-phone?phone={phone}</a>
<br>
Para validar números de celular: GET <a href="#">/doc-validators/validate-mobile?mobile={mobile}</a>
<br>
Para validar CNPJ: GET <a href="#">/doc-validators/validate-cnpj?cnpj={cnpj}</a>
<br>
Para validar CPF: GET <a href="#">/doc-validators/validate-cpf?cpf={cpf}</a>
<br>
Para validar PIS: GET <a href="#">/doc-validators/validate-pis?pis={pis}</a>
<br>
Para validar RG: GET <a href="#">/doc-validators/validate-rg?rg={rg}</a>
<br>
Para validar e-mail: GET <a href="#">/doc-validators/validate-email?email={email}</a>
<br>
Para validar CEP: GET <a href="#">/doc-validators/validate-cep?cep={cep}</a>
<br>
Para validar maiores e menores de 18 anos com dia, mês e ano: GET <a href="#">/doc-validators/validate-over18?year={year}&month={month}&dayOfMonth={dayOfMonth}</a>
<br>
Para validar maiores e menores de 18 anos com data no padrão ISO8601: GET <a href="#">/doc-validators/validate-over18-iso-8601?dateOfBirth={dateOfBirth}</a>
<br>
Para validar maiores e menores de 18 anos com data no padrão americano: GET <a href="#">/doc-validators/validate-over18-americandate?dateOfBirth={dateOfBirth}</a>
<br>
Para validar maiores e menores de 18 anos com data no padrão comum: GET <a href="#">/doc-validators/validate-over18-commondate?dateOfBirth={dateOfBirth}</a>
<br>
Para validar número de cartão de crédito: GET <a href="#">/doc-validators/validate-card-number?cardNumber={cardNumber}</a>
