package org.md2k.mcerebrum.core.constant;
/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

public class MCEREBRUM {
    public static class APP_ACCESS {
        public static String OP_DATAKIT_STOP="DATAKIT_STOP";
        public static String OP="OP";
        public static String APPCP_CHANGED="appcp_changed";
    }
    public static class CONFIG {
        public static final String UPDATE_TYPE_NEVER = "NEVER";
        public static final String UPDATE_TYPE_NOTIFY = "NOTIFY";
        public static final String UPDATE_TYPE_AUTOMATIC="AUTO";
        public static final String UPDATE_TYPE_MANUAL="MANUAL";
        public static final String TYPE_FREEBIE="FREEBIE";
        public static final String TYPE_SERVER="SERVER";
        public static final String TYPE_CONFIGURED="CONFIGURED";


        public enum TYPE_DOWNLOAD {
            GITHUB, URL, JSON, SERVER, UNKNOWN
        }

        public static TYPE_DOWNLOAD getDownloadType(String downloadLink){
            if(downloadLink==null) return TYPE_DOWNLOAD.UNKNOWN;
            if(downloadLink.toLowerCase().endsWith(".json"))
                return CONFIG.TYPE_DOWNLOAD.JSON;
            if(downloadLink.toLowerCase().endsWith(".zip"))
                return TYPE_DOWNLOAD.URL;
            if(downloadLink.split("/").length==2) return TYPE_DOWNLOAD.GITHUB;
            return TYPE_DOWNLOAD.SERVER;
        }
    }
    public static class APP {
        public static final String USE_AS_REQUIRED="REQUIRED";
        public static final String USE_AS_OPTIONAL="OPTIONAL";
        public static final String USE_AS_NOT_IN_USE="NOT_IN_USE";

        public static final String TYPE_STUDY="STUDY";
        public static final String TYPE_MCEREBRUM="MCEREBRUM";
        public static final String TYPE_DATAKIT="DATAKIT";
        public static final String UPDATE_TYPE_NEVER = "NEVER";
        public static final String UPDATE_TYPE_NOTIFY = "NOTIFY";
        public static final String UPDATE_TYPE_AUTOMATIC="AUTO";
        public static final String UPDATE_TYPE_MANUAL="MANUAL";

        public enum TYPE_DOWNLOAD {
            PLAYSTORE, URL, JSON, UNKNOWN
        }
    }
}
