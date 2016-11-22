/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.gameframework.commands;

import ru.sbt.gameframework.units.Unit;
import ru.sbt.gameframework.units.exceptions.CantExecuteCommand;

/**
 *
 * @author admin
 */
public interface Command {

    void execute(final Unit unit) throws CantExecuteCommand;
}
