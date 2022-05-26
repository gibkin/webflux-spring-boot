//package ru.homecredit.config;
//
//import io.netty.util.internal.StringUtil;
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactoryOptions;
//import io.r2dbc.spi.ConnectionFactoryOptions.Builder;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Flux;
//import ru.homecredit.config.property.R2DBCConfigurationProperties;
//
//import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
//import static io.r2dbc.spi.ConnectionFactoryOptions.USER;
//
//
//@Configuration
//public class DatasourceConfig {
//
//    @Bean
//    public ConnectionFactory connectionFactory(R2DBCConfigurationProperties properties) {
//
//        ConnectionFactoryOptions baseOptions = ConnectionFactoryOptions.parse(properties.getUrl());
//        Builder ob = ConnectionFactoryOptions.builder().from(baseOptions);
//        if (!StringUtil.isNullOrEmpty(properties.getUser())) {
//            ob.option(USER, properties.getUser());
//        }
//
//        if (!StringUtil.isNullOrEmpty(properties.getPassword())) {
//            ob.option(PASSWORD, properties.getPassword());
//        }
//
//        return ConnectionFactories.get(ob.build());
//    }
//
//
//    @Bean
//    public CommandLineRunner initDatabase(ConnectionFactory cf) {
//
//        return (args) ->
//                Flux.from(cf.create())
//                        .flatMap(c ->
//                                Flux.from(c.createBatch()
//                                                .add("drop table if exists Person")
//                                                .add("create table Person(" +
//                                                        "id IDENTITY(1,1)," +
//                                                        "firstname varchar(80) not null," +
//                                                        "lastname varchar (80) not null," +
//                                                        "patronymic varchar (80) not null)")
//                                                .add("insert into Person(firstname,lastname,patronymic)" +
//                                                        "values('IVAN','PETROV','KRUSENSTERN')")
//                                                .add("insert into Account(firsname,lastname,patronymic)" +
//                                                        "values('DMITRY','IVANOV','SIDOROVICH')")
//                                                .execute())
//                                        .doFinally((st) -> c.close())
//                        )
//                        .log()
//                        .blockLast();
//    }
//
//
//}