# easywallet

Manage all your expenses effortlessly:

 * Create wallet
 * Add Receipt
 * Split expense with friends (companions)
 * Settle up
 * Scan receipt image


This project use Spring MVC, Maven, Hibernate persistance, HTML5, Bootstrap, Javascript, Ajax

To run this project, you can clone it from git
```bash
git clone https://github.com/qoders/easywallet.git
```

Run maven update to setup dependency (in pom.xml file)

Modify `config.properties` which contains database and email config
```
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/easywallet
jdbc.username=root
jdbc.password=

mail.host=
mail.port=
mail.user=
mail.from=
mail.password=
mail.transport.protocol=
mail.smtp.auth=
mail.smtp.starttls.enable=
mail.debug=
```

