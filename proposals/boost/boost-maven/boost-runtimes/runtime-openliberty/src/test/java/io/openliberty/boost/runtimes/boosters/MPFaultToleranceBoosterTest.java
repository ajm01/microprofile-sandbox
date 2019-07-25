package io.openliberty.boost.runtimes.boosters;

import static boost.common.config.ConfigConstants.*;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.RestoreSystemProperties;
import org.junit.rules.TemporaryFolder;
import boost.runtimes.openliberty.LibertyServerConfigGenerator;

import boost.common.BoostLoggerI;
import io.openliberty.boost.runtimes.utils.BoosterUtil;
import io.openliberty.boost.runtimes.utils.CommonLogger;
import io.openliberty.boost.runtimes.utils.ConfigFileUtils;
import boost.runtimes.openliberty.boosters.*;

public class MPFaultToleranceBoosterTest {

    @Rule
    public TemporaryFolder outputDir = new TemporaryFolder();

    @Rule
    public final RestoreSystemProperties restoreSystemProperties = new RestoreSystemProperties();

    BoostLoggerI logger = CommonLogger.getInstance();

    /**
     * Test that the mpConfig-1.3 feature is added to server.xml when the MPConfig
     * booster version is set to 0.2-SNAPSHOT
     * 
     */
    @Test
    public void testMPFaultToleranceBoosterFeature11() throws Exception {

        LibertyServerConfigGenerator serverConfig = new LibertyServerConfigGenerator(
                outputDir.getRoot().getAbsolutePath(), logger);

        LibertyMPFaultToleranceBoosterConfig libMPFTConfig = new LibertyMPFaultToleranceBoosterConfig(BoosterUtil.createDependenciesWithBoosterAndVersion(LibertyMPFaultToleranceBoosterConfig.class, "0.1.1-SNAPSHOT"), logger);


        serverConfig.addFeature(libMPFTConfig.getFeature());
        serverConfig.writeToServer();

        String serverXML = outputDir.getRoot().getAbsolutePath() + "/server.xml";
        boolean featureFound = ConfigFileUtils.findStringInServerXml(serverXML,
                "<feature>" + MPFAULTTOLERANCE_11 + "</feature>");

        assertTrue("The " + MPFAULTTOLERANCE_11 + " feature was not found in the server configuration", featureFound);

    }

}
