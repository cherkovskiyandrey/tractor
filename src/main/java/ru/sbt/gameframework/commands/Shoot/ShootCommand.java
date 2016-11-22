/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.gameframework.commands.Shoot;

import ru.sbt.gameframework.commands.Command;
import ru.sbt.gameframework.commands.TurnClockwise.TurnClockwiseHandler;
import ru.sbt.gameframework.units.Unit;
import ru.sbt.gameframework.units.exceptions.CantExecuteCommand;
import ru.sbt.gameframework.units.exceptions.UnsupportedCommand;

/**
 *
 * @author admin
 */
public class ShootCommand implements Command {

    public void execute(Unit unit) throws CantExecuteCommand {
        if (unit instanceof TurnClockwiseHandler) {
            ((ShootHandler) unit).shoot();
            return;
        }
        throw new UnsupportedCommand();
    }
}
