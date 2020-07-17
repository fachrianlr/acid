package id.co.bankjateng.acid.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API For Tapping Data",
                description = "This API purpose to send data from vendor to Bank Jateng",
                contact = @Contact(name = "Bank Jateng", url = "https://bankjateng.co.id", email = "pnugroho@bankjateng.co.id")),
        servers = @Server(url = "http://localhost:8080/")
)
class OpenAPIConfig {
}
