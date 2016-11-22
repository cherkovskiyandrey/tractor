/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.gameframework;

import ru.sbt.gameframework.commands.Command;
import ru.sbt.gameframework.units.Unit;
import ru.sbt.gameframework.units.exceptions.CantExecuteCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 */
public class CommandBroker {

    private final List<Unit> units;

    public CommandBroker(final List<? extends Unit> units) {
        this.units = Collections.unmodifiableList(units);
    }

    public List<Unit> applyCommand(Command cmd) {
        final List<Unit> passed = new ArrayList<Unit>();
        for (Unit u : units) {
            try {
                cmd.execute(u);
                passed.add(u);
            } catch (CantExecuteCommand e) {
            }
        }
        return passed;
    }

    public void applyCommands(Command cmd, Command... cmds) {
        applyCommand(cmd);
        for (Command c : cmds) {
            applyCommand(c);
        }
    }
}
