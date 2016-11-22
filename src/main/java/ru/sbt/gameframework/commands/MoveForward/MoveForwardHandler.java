/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.gameframework.commands.MoveForward;

import ru.sbt.gameframework.units.exceptions.TractorInDitchException;

/**
 *
 * @author admin
 */
public interface MoveForwardHandler {

    void moveForward() throws TractorInDitchException;
}
