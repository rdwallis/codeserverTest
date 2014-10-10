package com.wallissoftware.sdbgtest.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.wallissoftware.sdbgtest.SDBGTest";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}