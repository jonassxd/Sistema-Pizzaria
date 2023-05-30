package com.nostra.pizzaria;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nostra.pizzaria.entities.Categoria;
import com.nostra.pizzaria.entities.Funcionario;
import com.nostra.pizzaria.entities.ItemPedido;
import com.nostra.pizzaria.entities.Pagamento;
import com.nostra.pizzaria.entities.Pedido;
import com.nostra.pizzaria.entities.Pessoa;
import com.nostra.pizzaria.entities.Produto;
import com.nostra.pizzaria.entities.enums.FuncionarioFuncao;
import com.nostra.pizzaria.entities.enums.StatusPedido;
import com.nostra.pizzaria.respositories.CategoriaRepository;
import com.nostra.pizzaria.respositories.FuncionarioRepository;
import com.nostra.pizzaria.respositories.ItemPedidoRepository;
import com.nostra.pizzaria.respositories.PedidoRepository;
import com.nostra.pizzaria.respositories.PessoaRepository;
import com.nostra.pizzaria.respositories.ProdutoRepository;

@SpringBootApplication
public class PizzariaApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PizzariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria sab1 = new Categoria(null, "Pizza Docê");
		Categoria sab2 = new Categoria(null, "Pizza Salgada");

		Produto p1 = new Produto(null, "Pizza de Calabresa",
				" linguiça calabresa, molho de tomate fresco, cebola, azeitona, queijo muçarela e orégano salpicado.",
				60.5, "");
		Produto p2 = new Produto(null, "Pizza de Banana Com Canela", "banana caramelizada, leite condensado e canela.",
				40.5, "");
		Produto p3 = new Produto(null, "Pizza de Chocolate", "chocolate preto ou branco.", 45.5, "");
		Produto p4 = new Produto(null, "Pizza de Sorvete", "Pizza de Chocolate com Sorvete napolitano .", 50.5, "");
		Produto p5 = new Produto(null, "Pizza Portuguesa",
				"contém cebola, azeitona, ervilha, queijo e presunto. No entanto, é comum encontrar variações que também levam ovo, milho, palmito, tomate, calabresa e até pimentão.  .",
				35.5, "");
		Produto p6 = new Produto(null, "Pizza Italiana", "mussarela, parmesão, salame italiano e tomates.", 42.5, "");

		categoriaRepository.saveAll(Arrays.asList(sab1, sab2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

		p1.getCategorias().add(sab2);
		p2.getCategorias().add(sab1);
		p3.getCategorias().add(sab1);
		p4.getCategorias().add(sab1);
		p5.getCategorias().add(sab2);
		p6.getCategorias().add(sab2);

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

		Pessoa c1 = new Pessoa(1L, "Jonas Eduardo", 20, "1231413", "199293849", "jonas@email.com");
		Pessoa c2 = new Pessoa(2L, "Mileide Lopes", 20, "1327838", "199297839", "mileide@email.com");
		Pessoa c3 = new Pessoa(3L, "Rebeca Kamilly", 13, "1232154", "199297529", "rebeca@email.com");
		Pessoa c4 = new Pessoa(4L, "Kelly Ribeiro", 42, "123124", "192832459", "kelly@email.com");
		Pessoa c5 = new Pessoa(5L, "Rogério Oliveira", 46, "321312", "191482345", "roger@email.com");

		Funcionario f1 = new Funcionario(1L, "Lionel Messi", 36, "199123912", "12315", "joao@nostra.com",
				FuncionarioFuncao.GERENTE);

		Funcionario f2 = new Funcionario(2L, "Ricardo Silva", 25, "198312516", "12315", "ric@nostra.com",
				FuncionarioFuncao.PIZZAIOLO);

		Funcionario f3 = new Funcionario(3L, "Jóse Augusto", 22, "192325856", "12315", "joseaugusto@nostra.com",
				FuncionarioFuncao.MOTOBOY);

		Funcionario f4 = new Funcionario(4L, "Maria Silva", 55, "192838275", "12315", "mariasilva@nostra.com",
				FuncionarioFuncao.LIMPEZA);

		funcionarioRepository.saveAll(Arrays.asList(f1, f2, f3, f4));

		Pedido o1 = new Pedido(null, Instant.parse("2023-05-20T20:33:07Z"), StatusPedido.AGUARDANDO_PAGAMENTO, c1);
		Pedido o2 = new Pedido(null, Instant.parse("2023-05-10T22:42:10Z"), StatusPedido.PAGO, c2);
		Pedido o3 = new Pedido(null, Instant.parse("2023-05-07T21:21:22Z"), StatusPedido.ENTREGUE, c3);
		Pedido o4 = new Pedido(null, Instant.parse("2023-05-07T19:21:22Z"), StatusPedido.CANCELADO, c4);

		pessoaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

		ItemPedido ip1 = new ItemPedido(o1, p1, 2, p1.getPreco());
		ItemPedido ip2 = new ItemPedido(o1, p3, 1, p3.getPreco());
		ItemPedido ip3 = new ItemPedido(o2, p3, 2, p3.getPreco());
		ItemPedido ip4 = new ItemPedido(o3, p5, 2, p5.getPreco());

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));

		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:54:07Z"), o1);
		o1.setPagamento(pag1);
		pedidoRepository.save(o1);

	}

}
