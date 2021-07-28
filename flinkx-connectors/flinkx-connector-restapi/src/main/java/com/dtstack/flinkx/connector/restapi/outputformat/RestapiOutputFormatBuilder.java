/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.flinkx.connector.restapi.outputformat;

import com.dtstack.flinkx.connector.restapi.common.RestapiWriterConfig;
import com.dtstack.flinkx.sink.format.BaseRichOutputFormatBuilder;

/**
 * @author : tiezhu
 * @date : 2020/3/12
 */
public class RestapiOutputFormatBuilder extends BaseRichOutputFormatBuilder {

    private RestapiOutputFormat format;

    public RestapiOutputFormatBuilder() {
        super.format = format = new RestapiOutputFormat();
    }

    public void setConfig(RestapiWriterConfig restapiWriterConfig) {
        super.setConfig(restapiWriterConfig);
        this.format.restapiWriterConfig = restapiWriterConfig;
    }

    @Override
    protected void checkFormat() {
        if (format.restapiWriterConfig.getUrl().isEmpty()) {
            throw new IllegalArgumentException("url is must");
        }
        if (format.restapiWriterConfig.getMethod().isEmpty()) {
            throw new IllegalArgumentException("method is must");
        }
    }
}
