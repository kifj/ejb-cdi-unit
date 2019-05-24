package iocunit.ejbresource;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.oneandone.iocunit.IocUnitRunner;
import com.oneandone.iocunit.analyzer.annotations.SutClasses;
import com.oneandone.iocunit.analyzer.annotations.TestClasses;
import com.oneandone.iocunit.ejb.persistence.TestPersistenceFactory;

import iocunit.ejbresource.simple.SutClass;
import iocunit.ejbresource.simple.SutClassWithQualifiedDatasource;
import iocunit.ejbresource.simple.SutProducesResources;

/**
 * @author aschoerk
 */
@RunWith(IocUnitRunner.class)
@TestClasses({TestPersistenceFactory.class, Test1DataSource2References.class})
@SutClasses({SutProducesResources.class, SutClass.class, SutClassWithQualifiedDatasource.class})
public class ProducesOneDatasourceTest {
    @Inject
    SutClass sutClass;

    @Inject
    SutClassWithQualifiedDatasource sutClassWithQualifiedDatasource;

    @Test
    public void canUseInjectedDatasource() throws SQLException {
        sutClass.createTableT();
    }

    @Test
    public void canUseDatasourceResourceInjected() {
        sutClassWithQualifiedDatasource.createTableT();
    }

    @Test
    public void canUseBothDatasources() throws SQLException {
        sutClassWithQualifiedDatasource.createTableT();
        try {
            sutClass.createTableT();
        } catch (SQLException e) {
            assert(e.getMessage().contains("already exists"));
        }
        sutClass.createTableS();
    }
}
