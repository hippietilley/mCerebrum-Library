package org.md2k.mcerebrum.core.access;
import org.md2k.mcerebrum.core.access.Info;

interface IMCerebrumService {
    void Initialize();
    Info GetInfo();
    void Configure();
    void Launch();
    void StartBackground();
    void StopBackground();
    void Report();
    void Clear();
    void Exit();
}
