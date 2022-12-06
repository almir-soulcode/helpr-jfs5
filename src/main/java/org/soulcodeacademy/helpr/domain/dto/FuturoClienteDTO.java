package org.soulcodeacademy.helpr.domain.dto;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class FuturoClienteDTO {

    @NotBlank(message = "O campo nome é obrigatório!")
    @Length(max = 120, message = "Limite de caracteres excedido!")
    protected String nome;

    @NotBlank(message = "O número de telefone é obrigatório!")
    private String telefone;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email é obrigatório!")
    protected String email;

    @CPF(message = "O CPF informado é inválido!")
    @NotBlank(message = "CPF é obrigatório!")
    protected String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

