package me.tapeline.qubic;

import me.tapeline.quailj.io.IO;
import me.tapeline.quailj.parsing.nodes.Node;
import me.tapeline.quailj.runtime.Runtime;

import java.io.File;

public class QubicRuntime extends Runtime {

    public QubicRuntime() {
    }

    public QubicRuntime(Node root, String code, File scriptHome, IO io, boolean doProfile) {
        super(root, code, scriptHome, io, doProfile);
    }

}
