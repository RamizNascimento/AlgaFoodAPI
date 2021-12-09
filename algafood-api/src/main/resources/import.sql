insert into cozinha (id, nome) values (1,'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('restauranteRamiz', '1', 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('restauranteVinicius', '2', 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('restauranteFulvia', '2', 2);

insert into forma_pagamento (id,descricao) values (1,"Cartao Credito")
insert into forma_pagamento (id,descricao) values (2,"Cartao Debito")
insert into forma_pagamento (id,descricao) values (3,"Dinheiro")
insert into forma_pagamento (id,descricao) values (4,"PIX")
insert into forma_pagamento (id,descricao) values (5,"Vale Refeicao")

insert into permissao (id, nome, descricao) values (1,"permissao1","descricao1")
insert into permissao (id, nome, descricao) values (2,"permissao2","descricao2")
insert into permissao (id, nome, descricao) values (3,"permissao3","descricao3")


insert into estado (id, nome) values (1, 'São Paulo');
insert into estado (id, nome) values (2, 'Rio de Janeiro');

insert into cidade (id, nome, estado_id) values (1,"Jaguare",1)
insert into cidade (id, nome, estado_id) values (2,"Olambra",1)
insert into cidade (id, nome, estado_id) values (3,"Olaria",2)
insert into cidade (id, nome, estado_id) values (4,"Cidade Deus",2)
insert into cidade (id, nome, estado_id) values (5,"hortolandia",2)


