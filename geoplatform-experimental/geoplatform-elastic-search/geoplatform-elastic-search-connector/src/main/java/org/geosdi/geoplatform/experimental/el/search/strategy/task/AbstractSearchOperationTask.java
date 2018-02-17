/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2018 geoSDI Group (CNR IMAA - Potenza - ITALY).
 * <p>
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see http://www.gnu.org/licenses/
 * <p>
 * ====================================================================
 * <p>
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole combination.
 * <p>
 * As a special exception, the copyright holders of this library give you permission
 * to link this library with independent modules to produce an executable, regardless
 * of the license terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the license of
 * that module. An independent module is a module which is not derived from or
 * based on this library. If you modify this library, you may extend this exception
 * to your version of the library, but you are not obligated to do so. If you do not
 * wish to do so, operation this exception statement from your version.
 */
package org.geosdi.geoplatform.experimental.el.search.strategy.task;

import com.google.common.base.Preconditions;
import org.elasticsearch.action.bulk.BulkResponse;
import org.geosdi.geoplatform.experimental.el.dao.ElasticSearchDAO;
import org.geosdi.geoplatform.experimental.el.search.operation.OperationByPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

import static org.geosdi.geoplatform.experimental.el.search.strategy.IGPOperationAsyncStrategy.AbstractOperationAsyncStrategy.PAGE_SIZE_LIMIT;


/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class AbstractSearchOperationTask implements Callable<BulkResponse> {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractSearchOperationTask.class);
    //
    protected final ElasticSearchDAO searchDAO;
    protected final OperationByPage page;
    protected final int start;
    protected final int taskNumber;

    public AbstractSearchOperationTask(ElasticSearchDAO theSearchDAO, OperationByPage thePage,
                                       int taskNumber) {
        Preconditions.checkNotNull(theSearchDAO, "Parameter SearchDAO must not be null.");
        Preconditions.checkNotNull(thePage, "Parameter Page must not be null.");
        this.searchDAO = theSearchDAO;
        this.page = thePage;
        this.taskNumber = taskNumber;
        this.start = (this.page.getFrom() + (this.taskNumber * PAGE_SIZE_LIMIT));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{"
                + " #taskNumber : " + this.taskNumber
                + ", @start : " + this.start
                + "}";
    }
}