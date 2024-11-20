# EcoSmartMonitor

[![Java](https://img.shields.io/badge/Java-17+-blue)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8.1+-brightgreen)](https://maven.apache.org/)
[![JAX-RS](https://img.shields.io/badge/JAX--RS-Jersey-orange)](https://eclipse-ee4j.github.io/jersey/)
[![Tomcat](https://img.shields.io/badge/Tomcat-10.0+-yellow)](https://tomcat.apache.org/)

**EcoSmartMonitor** é um sistema desenvolvido para monitorar e gerenciar o consumo energético de dispositivos em residências. Ele utiliza APIs RESTful para comunicação e oferece insights sobre eficiência energética.

## 📋 Tecnologias Utilizadas

- **Java** 17+
- **Maven** para gerenciamento de dependências.
- **JAX-RS** com a implementação **Jersey** para APIs RESTful.
- **Apache Tomcat** para execução e deployment.
- **Banco de Dados**: Configurável para qualquer SGBD compatível com JDBC.
- Integração com APIs externas para análise de consumo.

## 📂 Estrutura do Projeto

```plaintext
ecosmartmonitor/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/fiap/ecosmartmonitor/  # Código fonte
│   │   ├── resources/
│   │   │   └── META-INF/                    # Configurações JAX-RS
│   │   └── webapp/                          # Arquivos web (JSP, HTML, etc.)
├── target/                                  # Gerado pelo Maven
├── pom.xml                                  # Configuração Maven
├── Procfile                                 # Configuração para deployment
└── README.MD                                # Documentação