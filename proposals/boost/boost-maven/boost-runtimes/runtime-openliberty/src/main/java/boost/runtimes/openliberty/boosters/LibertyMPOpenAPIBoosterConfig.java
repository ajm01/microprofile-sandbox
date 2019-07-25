/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package boost.runtimes.openliberty.boosters;

import static boost.common.config.ConfigConstants.MPOPENAPI_10;

import java.util.Map;

import boost.common.BoostException;
import boost.common.BoostLoggerI;
import boost.common.boosters.MPOpenAPIBoosterConfig;
import boost.runtimes.openliberty.LibertyServerConfigGenerator;
import boost.runtimes.openliberty.boosters.LibertyBoosterI;

public class LibertyMPOpenAPIBoosterConfig extends MPOpenAPIBoosterConfig implements LibertyBoosterI {

    public LibertyMPOpenAPIBoosterConfig(Map<String, String> dependencies, BoostLoggerI logger) throws BoostException {
        super(dependencies, logger);
    }

    @Override
    public String getFeature() {
        if (getVersion().equals(MP_OPENAPI_VERSION_10)) {
            return MPOPENAPI_10;
        }
        return null;
    }

    @Override
    public void addServerConfig(LibertyServerConfigGenerator libertyServerConfigGenerator) {

    }
}
